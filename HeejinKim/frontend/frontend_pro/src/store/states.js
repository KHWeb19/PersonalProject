export default{

members:[],
member:null,

userInfo: JSON.parse(localStorage.getItem('userInfo')),
token: localStorage.getItem('token'),

isAuth: false,
//isAuth: true,,(일단 작업하려면 이렇게 해놓고)

auth: null,
auths: [],

//커뮤니티 게시판
board: null,
boards: [],

reservation:null,
reservations:[],


reservationIdLists:[],

bookInfo:[],

//seatsInfo:"",

boardComments:[],

/*
session: null,
isLogin: false,
loginMemberNo: null,
auth: null */

session: [],

}
