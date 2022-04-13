import {
    FETCH_MEMBER,

    FETCH_FOOD_BOARD_LIST,
    FETCH_FOOD_BOARD
    
} from './mutation-types'

export default {
    [FETCH_MEMBER](state, userInfo){
        state.userInfo = userInfo
    },
    [FETCH_FOOD_BOARD_LIST](state, foodBoards){
        state.foodBoards = foodBoards
    },
    [FETCH_FOOD_BOARD](state, foodBoard){
        state.foodBoard = foodBoard
    }

}