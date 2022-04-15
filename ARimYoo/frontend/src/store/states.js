export default {

    communityBoards: [],
    communityBoard: null,
    communityComments: [],
    
    member: null,
    
    token: localStorage.getItem('token'),
    userInfo: JSON.parse(localStorage.getItem('userInfo'))

}