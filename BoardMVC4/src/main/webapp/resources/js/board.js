let memID = '';
let csrfTokenValue= document.querySelector("#csrf").value;
let csrfTokenName= document.querySelector("#csrf").name; // _crsf

function loadData(mvoID) {
  memID = mvoID;
  loadList();
}

function loadList() {
  fetch("boards")
    .then(response => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then(data => makeView(data, memID))
    .catch(error => {
      console.error("Error occurred while processing the request:", error);
    });
}

function makeView(data, memID) {

  const view = document.querySelector("#view");
  const wfrom = document.querySelector("#wfrom");
  let listHtml = `
        <table class='table table-bordered'>
            <tr>
                <td>번호</td>
                <td>제목</td>
                <td>작성자</td>
                <td>작성일</td>
                <td>조회수</td>
            </tr>
    `

  console.log("data=", data);

  data.forEach(obj => {
    console.log("obj=", obj);
    listHtml += `
            <tr>
                <td>${obj.idx}</td>
                <td id='t${obj.idx}'><a href='javascript:goContent(${obj.idx})'><c:out value='${obj.title}'/> </a></td>
                <td>${obj.writer}</td>
                <td>${obj.indate.split(' ')[0]}</td>
                <td id='cnt${obj.idx}'>${obj.count}</td>
            </tr>
            <tr id='c${obj.idx}' style='display:none'>
                <td>내용</td>
                <td colspan='4'>
                    <textarea id='ta${obj.idx}' readonly rows='7' class='form-control'></textarea>
                    <br/>
        `;

    if (memID != '' && memID === obj.memID) {
      listHtml += `
                <span id='ub${obj.idx}'><button class='btn btn-success btn-sm' onclick='javascript:goUpdateForm(${obj.idx})'>수정화면</button></span>&nbsp;
                <button class='btn btn-warning btn-sm' onclick='goDelete(${obj.idx})'>삭제</button>
            `;
    } else {
      listHtml += `
                <span id='ub${obj.idx}'><button disabled class='btn btn-success btn-sm' onclick='javascript:goUpdateForm(${obj.idx})'>수정화면</button></span>&nbsp;
                <button disabled class='btn btn-warning btn-sm' onclick='goDelete(${obj.idx})'>삭제</button>
            `;
    }

    listHtml += `
                </td>
            </tr>
        `;
  });
  // 로그인을 해야 보이는 부분
  if (memID != '') {
    listHtml += `
            <tr>
                <td colspan='5'>
                    <button class='btn btn-primary btn-sm' onclick='goForm()'>글쓰기</button>
                </td>
            </tr>
        `;
  }

  listHtml += "</table>";
  view.innerHTML = listHtml;
  view.style.display = "block";
  wfrom.style.display = "none";
}

function goForm() {
  document.querySelector("#view").style.display = "none";
  document.querySelector("#wfrom").style.display = "block";
}

function goList() {
  document.querySelector("#view").style.display = "block";
  document.querySelector("#wfrom").style.display = "none";
}

function goInsert() {
  let form = document.getElementById("frm");
  fetch("boards", {
      method: "POST",
      body: new URLSearchParams({ // 일반 객체를 form data형식으로 변환해주는 클래스  --> @ModelAttribute
        memID: memID,
        title: form.title.value,
        content: form.content.value,
        writer: form.writer.value,
        [csrfTokenName]: csrfTokenValue
      })
    })
    .then(loadList)
    .catch(error => {
      console.error("Error occurred while processing the request:", error);
    });

  document.querySelector("#fclear").click();
}

function goContent(idx) {
  const contentRow = document.querySelector(`#c${idx}`);
  if (contentRow.style.display === "none") {
    fetch(`boards/${idx}`)
      .then(response => response.json())
      .then(data => {
        document.querySelector(`#ta${idx}`).value = data.content; // textarea객체
            document.querySelector(`#cnt${idx}`).textContent = data.count;// 조회수 증가 
      })
      .catch(error => {
        console.error("Error occurred while processing the request:", error);
      });

    contentRow.style.display = "table-row";
    document.querySelector(`#ta${idx}`).readOnly = true;
  } else {
    contentRow.style.display = "none";

  }
}

function goDelete(idx) {
  fetch(`boards/${idx}`, {
      method: "DELETE",
      headers: {
        "X-CSRF-TOKEN": csrfTokenValue,
      },
    })
    .then(loadList)
    .catch(error => {
      console.error("Error occurred while processing the request:", error);
    });
}


function goUpdateForm(idx) {
  document.querySelector(`#ta${idx}`).readOnly = false;

  const title = document.querySelector(`#t${idx}`).textContent;
  const newInput = `<input type='text' id='nt${idx}' class='form-control' value='${title}'/>`;
  document.querySelector(`#t${idx}`).innerHTML = newInput;

  const newButton = `<button class='btn btn-primary btn-sm' onclick='goUpdate(${idx})'>수정</button>`;
  document.querySelector(`#ub${idx}`).innerHTML = newButton;
}

function goUpdate(idx) {
  const title = document.querySelector(`#nt${idx}`).value;
  const content = document.querySelector(`#ta${idx}`).value;

  fetch(`boards/${idx}?${csrfTokenName}=${csrfTokenValue}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
      },
      body: JSON.stringify({ idx, title, content }),
    })
    .then(loadList)
    .catch(error => {
      console.error("Error occurred while processing the request:", error);
    });
}