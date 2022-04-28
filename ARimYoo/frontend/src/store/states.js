export default {

    communityBoards: [],
    communityBest: [],
    communityBoard: null,
    communityComments: [],

    reviews: [],
    reviewBest: [],
    review: null,
    reviewComments: [],

    studies: [],
    study: null,
    studyComments: [],
    
    projects: [],
    project: null,
    projectComments: [],

    markets: [],
    market: null,
    marketComments:[],

    member: null,
    memberStudies: [],
    memberStudy: null,
    memberProjects: [],
    memberProject: null,
    
    token: localStorage.getItem('token'),
    userInfo: JSON.parse(localStorage.getItem('userInfo'))

}