let messageTypeElement = document.querySelector('#messageType');
let myMessageModal = document.querySelector('#myMessage');

function actionModal(msgType, msg) {
  console.log(msgType, msg);

  if (msgType != '' && msg != '') {

    if(msgType=='성공 메세지'){
      kindOfModal('panel-success');
    }else{
      kindOfModal('panel-warning');
    }

    let msgTitle = document.querySelector('.modal-title');
    msgTitle.innerHTML = msgType;
    
    changeMsg(msg);
    showModal();
  }
}

let close = document.querySelector('.close');
close.addEventListener('click', () => {
	closeModal();
});

let kindOfModal = (kind)=>{
  messageTypeElement.classList.add(kind);
}

let showModal= ()=>{
  myMessageModal.classList.remove('fade');
  myMessageModal.classList.add('show');
}

let closeModal= ()=>{
  myMessageModal.classList.add('fade');
  myMessageModal.classList.remove('show');
}

let changeMsg= (msg)=>{
  let msgBody = document.querySelector('.modal-body p');
  msgBody.innerHTML = msg;
};