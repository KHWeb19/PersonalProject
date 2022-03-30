import {
    FETCH_FREE_BOARD_LIST,
    FETCH_FREE_BOARD
    
} from './mutation-types'

export default {
    [FETCH_FREE_BOARD_LIST] (state, freeBoards) {
        state.freeBoards = freeBoards
    },
    [FETCH_FREE_BOARD] (state, freeBoard) {
        state.freeBoard = freeBoard
    }
}