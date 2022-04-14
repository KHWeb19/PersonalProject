import {
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_PRODUCT_BOARD_LIST,
    FETCH_PRODUCT_BOARD,
    FETCH_JPA_BOARD_LIST,
    FETCH_JPA_BOARD,
    FETCH_BUSINESS_MEMBER,
    CRAWL_START,
    FETCH_JPA_BOARD_LIST1,
    FETCH_JPA_BOARD1,
    FETCH_JPA_BOARD_LIST2,
    FETCH_JPA_BOARD2,
    FETCH_JPA_BOARD_LIST3,
    FETCH_JPA_BOARD3,
    FETCH_JPA_BOARD_LIST4,
    FETCH_JPA_BOARD4


} from './mutation-types'

import axios from 'axios'
import router from '@/router'
// npm install axios --save-dev

export default {
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/48th/vueboard/list')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/49th/vueboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    fetchProductBoardList ({ commit }) {
        return axios.get('http://localhost:7777/53th/vueproduct/list')
                .then((res) => {
                    commit(FETCH_PRODUCT_BOARD_LIST, res.data)
                })
    },
    fetchProductBoard ({ commit }, productNo) {
        return axios.get(`http://localhost:7777/53th/vueproduct/${productNo}`)
                .then((res) => {
                    commit(FETCH_PRODUCT_BOARD, res.data)
                })
    },
    fetchJpaBoardList ({ commit }) {
        return axios.get('http://localhost:7777/62th/board/list')
            .then((res) => {
                commit(FETCH_JPA_BOARD_LIST, res.data)
            })
    },

    fetchJpaBoardList1 ({ commit }, keyword) {
        let url = 'http://localhost:7777/62th/board1/list1';
        if (keyword != undefined) {
            url += '?keyword='+encodeURIComponent(keyword);
        }
        return axios.get(url)
            .then((res) => {
                commit(FETCH_JPA_BOARD_LIST1, res.data)
            })
    },

          
    fetchJpaBoardList2 ({ commit }) {
        return axios.get('http://localhost:7777/62th/board2/list2')
            .then((res) => {
                commit(FETCH_JPA_BOARD_LIST2, res.data)
            })
    },

    fetchJpaBoardList3 ({ commit }) {
        return axios.get('http://localhost:7777/62th/board3/list3')
            .then((res) => {
                commit(FETCH_JPA_BOARD_LIST3, res.data)
            })
    },

    fetchJpaBoardList4 ({ commit }) {
        return axios.get('http://localhost:7777/62th/board4/list4')
            .then((res) => {
                commit(FETCH_JPA_BOARD_LIST4, res.data)
            })
    },








    fetchJpaBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/62th/board/${boardNo}`)
            .then((res) => {
                commit(FETCH_JPA_BOARD, res.data)
            })
        },


            fetchJpaBoard1 ({ commit }, boardNo) {
                return axios.get(`http://localhost:7777/62th/board1/${boardNo}`)
                    .then((res) => {
                        commit(FETCH_JPA_BOARD1, res.data)
                    })
            },

              
            fetchJpaBoard2 ({ commit }, boardNo) {
                return axios.get(`http://localhost:7777/62th/board2/${boardNo}`)
                    .then((res) => {
                        commit(FETCH_JPA_BOARD2, res.data)
                    })
            },

            fetchJpaBoard3 ({ commit }, boardNo) {
                return axios.get(`http://localhost:7777/62th/board3/${boardNo}`)
                    .then((res) => {
                        commit(FETCH_JPA_BOARD3, res.data)
                    })
            },

            fetchJpaBoard4 ({ commit }, boardNo) {
                return axios.get(`http://localhost:7777/62th/board4/${boardNo}`)
                    .then((res) => {
                        commit(FETCH_JPA_BOARD4, res.data)
                    })
            },









    fetchBusinessMember ({ commit }) {
        return axios.get('http://localhost:7777/63th/jpaMember/checkBusiness')
            .then((res) => {
                commit(FETCH_BUSINESS_MEMBER, res.data)
            })
    },
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/64th/crawl/' + `${category}`)
            .then(({ data }) => {
                commit(CRAWL_START, data)

                if (window.location.pathname !== '/daumNewsCrawl') {
                    router.push('/daumNewsCrawl')
                }
            })
    }
}

