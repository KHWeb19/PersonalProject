export default {

    communityBoards: [],
    communityBoard: null,
    communityComments: [],

    reviews: [],
    review: null,
    reviewComments: [],

    studies: [],
    study: null,
    studyComments: [],
    
    projects: [],
    project: null,
    projectComments: [],
    
    member: null,
    
    token: localStorage.getItem('token'),
    userInfo: JSON.parse(localStorage.getItem('userInfo'))

}