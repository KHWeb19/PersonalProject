 import {
    FETCH_MEMBER,
    FETCH_MEMBER_STUDY_LIST,
    FETCH_MEMBER_STUDY,
    FETCH_MEMBER_PROJECT_LIST,
    FETCH_MEMBER_PROJECT,
    FETCH_COMMUNITY_BOARD_LIST,
    FETCH_COMMUNITY_BOARD_BEST_LIST,
    FETCH_COMMUNITY_BOARD,
    FETCH_COMMUNITY_COMMENTS_LIST,
    FETCH_REVIEW_LIST,
    FETCH_REVIEW_BEST_LIST,
    FETCH_REVIEW,
    FETCH_REVIEW_COMMENTS_LIST,
    FETCH_STUDY_LIST,
    FETCH_STUDY,
    FETCH_STUDY_COMMENTS_LIST,
    FETCH_PROJECT_LIST,
    FETCH_PROJECT,
    FETCH_PROJECT_COMMENTS_LIST,
    FETCH_MARKET_LIST,
    FETCH_MARKET,
    FETCH_MARKET_COMMENTS_LIST,

    FETCH_MAIN_COMMUNITY_LIST,
    FETCH_MAIN_MARKET_LIST,
    FETCH_MAIN_REVIEW_LIST,
    FETCH_MAIN_STUDY_LIST,
    FETCH_MAIN_PROJECT_LIST,
    
 } from './mutation-types'

export default {

    [FETCH_MEMBER](state, userInfo) {
        state.userInfo = userInfo
    },
    [FETCH_MEMBER_STUDY_LIST](state, memberStudies) {
        state.memberStudies = memberStudies
    },
    [FETCH_MEMBER_STUDY](state, memberStudy) {
        state.memberStudy = memberStudy
    },
    [FETCH_MEMBER_PROJECT_LIST](state, memberProjects) {
        state.memberProjects = memberProjects
    },
    [FETCH_MEMBER_PROJECT](state, memberProject) {
        state.memberProject = memberProject
    },
    [FETCH_COMMUNITY_BOARD_LIST](state, communityBoards) {
        state.communityBoards = communityBoards 
    },
    [FETCH_COMMUNITY_BOARD_BEST_LIST](state, communityBest) {
        state.communityBest = communityBest
    },
    [FETCH_COMMUNITY_BOARD](state, communityBoard) {
        state.communityBoard = communityBoard
    },
    [FETCH_COMMUNITY_COMMENTS_LIST](state, communityComments) {
        state.communityComments = communityComments
    },
    [FETCH_REVIEW_LIST](state, reviews) {
        state.reviews = reviews
    },
    [FETCH_REVIEW_BEST_LIST](state, reviewBest) {
        state.reviewBest = reviewBest
    },
    [FETCH_REVIEW](state, review) {
        state.review = review
    },
    [FETCH_REVIEW_COMMENTS_LIST](state, reviewComments) {
        state.reviewComments = reviewComments
    },
    [FETCH_STUDY_LIST](state, studies) {
        state.studies = studies
    },
    [FETCH_STUDY](state, study) {
        state.study = study
    },
    [FETCH_STUDY_COMMENTS_LIST](state, studyComments) {
        state.studyComments = studyComments
    },
    [FETCH_PROJECT_LIST](state, projects) {
        state.projects = projects
    },
    [FETCH_PROJECT](state, project) {
        state.project = project
    },
    [FETCH_PROJECT_COMMENTS_LIST](state, projectComments) {
        state.projectComments = projectComments
    },
    [FETCH_MARKET_LIST](state, markets) {
        state.markets = markets
    },
    [FETCH_MARKET](state, market) {
        state.market = market
    },
    [FETCH_MARKET_COMMENTS_LIST](state, marketComments) {
        state.marketComments = marketComments
    },
    [FETCH_MAIN_COMMUNITY_LIST](state, mainCommunityList) {
        state.mainCommunityList = mainCommunityList
    },
    [FETCH_MAIN_MARKET_LIST](state, mainMarketList) {
        state.mainMarketList = mainMarketList
    },
    [FETCH_MAIN_REVIEW_LIST](state, mainReviewList) {
        state.mainReviewList = mainReviewList
    },
    [FETCH_MAIN_STUDY_LIST](state, mainStudyList) {
        state.mainStudyList = mainStudyList
    },
    [FETCH_MAIN_PROJECT_LIST](state, mainProjectList) {
        state.mainProjectList = mainProjectList
    },



}
