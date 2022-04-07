import {
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_PRODUCT_BOARD_LIST,
    FETCH_PRODUCT_BOARD,
    FETCH_JPA_BOARD_LIST,
    FETCH_JPA_BOARD,
    FETCH_JPA_BOARD_LIST1,
    FETCH_JPA_BOARD1,
    FETCH_JPA_BOARD_LIST2,
    FETCH_JPA_BOARD2,
    FETCH_JPA_BOARD_LIST3,
    FETCH_JPA_BOARD3,   
    FETCH_JPA_BOARD_LIST4,
    FETCH_JPA_BOARD4,
 

    FETCH_BUSINESS_MEMBER,
    CRAWL_START
} from './mutation-types'

export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_PRODUCT_BOARD_LIST] (state, productBoards) {
        state.productBoards = productBoards
    },
    [FETCH_PRODUCT_BOARD] (state, productBoard) {
        state.productBoard = productBoard
    },
    [FETCH_JPA_BOARD_LIST] (state, boards) {
        state.jpaBoards = boards
    },
    [FETCH_JPA_BOARD] (state, board) {
        state.jpaBoard = board
    },
    [FETCH_BUSINESS_MEMBER] (state, businessMembers) {
        state.businessMembers = businessMembers
    },
    [CRAWL_START] (state, payload) {
        state.crawlLists = payload
    },

    [FETCH_JPA_BOARD_LIST1] (state, boards1) {
        state.jpaBoards1 = boards1
    },
    [FETCH_JPA_BOARD1] (state, board1) {
        state.jpaBoard1 = board1
    },
     [FETCH_JPA_BOARD_LIST2] (state, boards2) {
            state.jpaBoards2 = boards2
    },
    [FETCH_JPA_BOARD2] (state, board2) {
            state.jpaBoard2 = board2
    },
    [FETCH_JPA_BOARD_LIST3] (state, boards3) {
        state.jpaBoards3 = boards3
},
[FETCH_JPA_BOARD3] (state, board3) {
        state.jpaBoard3 = board3
},

[FETCH_JPA_BOARD_LIST4] (state, boards4) {
    state.jpaBoards4 = boards4
},
[FETCH_JPA_BOARD4] (state, board4) {
    state.jpaBoard4 = board4
},




}
    


