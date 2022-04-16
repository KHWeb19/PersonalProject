export default {

    communityBoards: [],
    communityBoard: null,
    communityComments: [],

    reviews: [],
    review: null,
    reviewComments: [],
    
    member: null,
    
    token: localStorage.getItem('token'),
    userInfo: JSON.parse(localStorage.getItem('userInfo'))

}