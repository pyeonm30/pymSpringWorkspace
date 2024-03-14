let check = false;

function registerCheck(cp) {

  let memID = document.getElementById('memID').value;
  if (!memID) {
    kindOfModal('panel-info');
    changeMsg('값을 넣어주세요');
    showModal();
    return;
  }
  fetch(cp + '/member/memRegisterCheck.do?memID=' + encodeURIComponent(memID))
    .then((response) => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then((result) => {
      console.log("result", result)
      if (result === 1) {
        kindOfModal('panel-success');
        changeMsg('사용할 수 있는 아이디입니다.');
        check = true;
      } else {
        kindOfModal('panel-warning');
        changeMsg('사용할 수 없는 아이디입니다.');
        check = false;
      }
      showModal();
    })
    .catch((error) => {
      console.error('There was a problem with the fetch operation:', error);
    });


}

function passwordCheck() {
  let memPassword1 = document.getElementById('memPassword1').value;
  let memPassword2 = document.getElementById('memPassword2').value;
  if (memPassword1 !== memPassword2) {
    document.getElementById('passMessage').innerHTML =
      '비밀번호가 서로 일치하지 않습니다.';
  } else {
    document.getElementById('passMessage').innerHTML = '';
  }
}

function goInsert() {
  let form = document.forms['frm'];
  if (form.memAge.value < 1 || form.memAge.value > 100) {
    alert(' 올바른 나이 입력해주세요 ');
    return false;
  }

  if (check) {
    document.forms['frm'].submit();
  } else {
    changeMsg('아이디 중복체크 해주세요');
    showModal();
  }

}


function goUpdate() {

  let form = document.forms['updateForm'];
  if (form.memAge.value < 1 || form.memAge.value > 100) {
    alert(' 올바른 나이 입력해주세요 ');
    return false;
  }

  if (!form.memPassword1.value || !form.memPassword2.value) {
    changeMsg('비밀번호 입력해주세요');
    showModal();
    return false;
  }

  form.submit();

}