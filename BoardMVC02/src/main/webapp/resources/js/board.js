let memID = '';

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
                <td id='t${obj.idx}'><a href='javascript:goContent(${obj.idx})'>${obj.title}</a></td>
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

