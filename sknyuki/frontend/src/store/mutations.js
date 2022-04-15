import {
    FETCH_BRAND_CHECK_BOARD_LIST,
    FETCH_BRAND_CHECK_BOARD,
} from './mutation-types'

export default {
    [FETCH_BRAND_CHECK_BOARD_LIST] (state, brandCheckBoards) {
        state.BrandCheckBoards = brandCheckBoards
       
    },
    [FETCH_BRAND_CHECK_BOARD ] (state, brandCheckBoard) {
        state.BrandCheckBoard = brandCheckBoard
    }
}
