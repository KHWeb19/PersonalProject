import {
    FETCH_MEMBER,

    FETCH_FOOD_BOARD_LIST,
    FETCH_FOOD_BOARD,

    FETCH_BEST_FOOD_LIST,
    FETCH_FOOD_BOARD_COMMENTS_LIST
    
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
    },
    [FETCH_BEST_FOOD_LIST](state, bestFoodBoards){
        state.bestFoodBoards = bestFoodBoards
    },
    [FETCH_FOOD_BOARD_COMMENTS_LIST](state, foodBoardComments){
        state.foodBoardComments = foodBoardComments
    }



}