import {
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_BOOK,
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    FETCH_MEMBERAUTH_LIST,
    FETCH_MEMBERAUTH,
    FETCH_BOOK_READ,
    FETCH_ROOM_LIST,
    FETCH_ROOM,
    FETCH_USER,
    FETCH_RESERVE_LIST,
    LOGIN_SUCCESS,
    LOGIN_ERROR,
    LOGOUT,
    CRAWL_START,

} from './mutation-types'

import axios from 'axios'
import router from '../router'
import cookies from 'vue-cookies'


export default {
    fetchBoardList({ commit }) {
        return axios.get('http://localhost:7777/board/lists')
            .then((res) => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
            .then((res) => {
                commit(FETCH_BOARD, res.data)
            })
    },
    fetchUser({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/jpaMember/${memberNo}`)
            .then((res) => {
                commit(FETCH_USER, res.data)
            })
    },
    fetchBook({ commit }, bookNo) {
        return axios.get(`http://localhost:7777/room/${bookNo}`)
            .then((res) => {
                commit(FETCH_BOOK, res.data)
                commit(FETCH_BOOK_READ, res.data.dateList[0])
            })
    },
    fetchMemberAuthList({ commit }) {
        return axios.get('http://localhost:7777/memberManage/authLists')
            .then((res) => {
                commit(FETCH_MEMBERAUTH_LIST, res.data)
            })
    },
    fetchMemberList({ commit }) {
        return axios.get('http://localhost:7777/memberManage/lists')
            .then((res) => {
                commit(FETCH_MEMBER_LIST, res.data)
            })
    },
    fetchMember({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/memberManage/manager/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
                commit(FETCH_MEMBERAUTH, res.data.authList[0])
            })
    },
    fetchRoomList({ commit }) {
        return axios.get('http://localhost:7777/roomManage/lists')
            .then((res) => {
                commit(FETCH_ROOM_LIST, res.data)
            })
    },
    fetchRoom({ commit }, bookNo) {
        return axios.get(`http://localhost:7777/roomManage/${bookNo}`)
            .then((res) => {
                commit(FETCH_ROOM, res.data)

            })
    },
    fetchReserveList({ commit }) {
        return axios.get('http://localhost:7777/roomManage/reservationLists')
            .then((res) => {
                commit(FETCH_RESERVE_LIST, res.data)
            })
    },
    async login({ commit }, { userId, password }) {
        axios.post('http://localhost:7777/jpaMember/login', { userId, password })
            .then(res => {
                if (res.data != "") {
                    alert('로그인이 완료되었습니다.')
                    cookies.set("user", userId, '1h')
                    cookies.set("auth", res.data.authList[0].auth, '1h')
                    this.state.session = res.data
                    commit(LOGIN_SUCCESS)
                    router.push({ name: 'MainPage' })
                } if (res.data == "") {
                    alert('아이디와 비밀번호를 확인해주세요.')
                    commit(LOGIN_ERROR)
                }
            })
            .catch(res => {
                console.log(res)
            })
    },

    logout({ commit }) {
        cookies.remove("user")
        cookies.remove("auth")
        commit(LOGOUT)
        alert('로그아웃.')
        location.href = '/hawul'
    },
    async crawlFind({ commit }, category) {
        axios.get('http://localhost:7777/' + `${category}`)
            .then(({ data }) => {
                commit(CRAWL_START, data)
                if (window.location.pathname !== '/tourCrawler') {
                    router.push('/tourCrawler')
                }
            })
    },
}