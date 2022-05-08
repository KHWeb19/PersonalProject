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

import axios from 'axios'

export default {

    fetchMember({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/Member/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
        })
    },
    fetchMemberStudyList({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/study/list/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER_STUDY_LIST, res.data)
            })
    },
    fetchMemberStudy({ commit }, studyNo) {
        return axios.get(`http://localhost:7777/study/${studyNo}`)
            .then((res) => {
            commit(FETCH_MEMBER_STUDY,res.data)
        })
    },
    fetchMemberProjectList({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/project/list/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER_PROJECT_LIST, res.data)
            })
    },
    fetchMemberProject({ commit }, projectNo) {
        return axios.get(`http://localhost:7777/project/${projectNo}`)
            .then((res) => {
                commit(FETCH_MEMBER_PROJECT, res.data)
            })
    },
    fetchCommunityBoardList({ commit }) {
        return axios.get('http://localhost:7777/board/community/list')
            .then((res) => {
                commit(FETCH_COMMUNITY_BOARD_LIST, res.data)
        })
    },
    fetchCommunityBoardBestList({ commit }) {
        return axios.get('http://localhost:7777/board/community/popular')
            .then((res) => {
                commit(FETCH_COMMUNITY_BOARD_BEST_LIST, res.data)
        })
    },
    fetchCommunityBoard({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/community/${boardNo}`)
            .then((res) => {
                commit(FETCH_COMMUNITY_BOARD, res.data)
                console.log(res.data)
        })
        
    },
    fetchCommunityCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/community/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_COMMUNITY_COMMENTS_LIST, res.data)
        })
    },
    fetchReviewList({ commit }) {
        return axios.get('http://localhost:7777/board/review/list')
            .then((res) => {
            commit(FETCH_REVIEW_LIST, res.data)
        })
    },
    fetchReviewBestList({ commit }) {
        return axios.get('http://localhost:7777/board/review/popular')
            .then((res) => {
                commit(FETCH_REVIEW_BEST_LIST, res.data)
        } )
    },
    fetchReview({ commit }, reviewNo) {
        return axios.get(`http://localhost:7777/board/review/${reviewNo}`)
            .then((res) => {
                commit(FETCH_REVIEW, res.data)
                console.log(res.data)
            })

    },
    fetchReviewCommentsList({ commit }, reviewNo) {
        return axios.get(`http://localhost:7777/board/review/${reviewNo}/comment/list`)
            .then((res) => {
            commit(FETCH_REVIEW_COMMENTS_LIST, res.data)
        })
    },
    fetchStudyList({ commit }) {
        return axios.get('http://localhost:7777/board/study/list')
            .then((res) => {
            commit(FETCH_STUDY_LIST, res.data)
        })
    },
    fetchStudy({ commit }, studyNo) {
        return axios.get(`http://localhost:7777/board/study/${studyNo}`)
            .then((res) => {
            commit(FETCH_STUDY, res.data)
        })
    },
    fetchStudyCommentsList({ commit }, studyNo) {
        return axios.get(`http://localhost:7777/board/study/${studyNo}/comment/list`)
            .then((res) => {
            commit(FETCH_STUDY_COMMENTS_LIST, res.data)
        })
    },
    fetchProjectList({ commit }) {
        return axios.get('http://localhost:7777/board/project/list')
            .then((res) => {
                commit(FETCH_PROJECT_LIST, res.data)
            })
    },
    fetchProject({ commit }, projectNo) {
        return axios.get(`http://localhost:7777/board/project/${projectNo}`)
            .then((res) => {
                commit(FETCH_PROJECT, res.data)
            })
    },
    fetchProjectCommentsList({ commit }, projectNo) {
        return axios.get(`http://localhost:7777/board/project/${projectNo}/comment/list`)
            .then((res) => {
                commit(FETCH_PROJECT_COMMENTS_LIST, res.data)
            })
    },
    fetchMarketList({ commit }) {
        return axios.get('http://localhost:7777/board/market/list')
            .then((res) => {
                commit(FETCH_MARKET_LIST, res.data)
            })
    },
    fetchMarket({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/market/${boardNo}`)
            .then((res) => {
                commit(FETCH_MARKET, res.data)
            })
    },
    fetchMarketCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/market/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_MARKET_COMMENTS_LIST, res.data)
            })
    },

    fetchMainCommunityList({ commit } , keyword) {
        return axios.post('http://localhost:7777/board/community/search', {keyword})
            .then((res) => {
                console.log(keyword)
                commit(FETCH_MAIN_COMMUNITY_LIST, res.data)
            })
    },
    fetchMainMarketList({ commit }, keyword) {
        return axios.post('http://localhost:7777/board/market/search', {keyword})
            .then((res) => {
                commit(FETCH_MAIN_MARKET_LIST, res.data)
            })
    },
    fetchMainReviewList({ commit }, keyword) {
        return axios.post('http://localhost:7777/board/review/search' ,{keyword} )
            .then((res) => {
                commit(FETCH_MAIN_REVIEW_LIST, res.data)
            })
    },
    fetchMainStudyList({ commit }, keyword) {
        return axios.post('http://localhost:7777/board/study/search', {keyword})
            .then((res) => {
                commit(FETCH_MAIN_STUDY_LIST, res.data)
            })
    },
    fetchMainProjectList({ commit }, keyword) {
        return axios.post('http://localhost:7777/board/project/search', {keyword})
            .then((res) => {
                commit(FETCH_MAIN_PROJECT_LIST, res.data)
            })
    }
}