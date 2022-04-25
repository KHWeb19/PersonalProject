import {
    FETCH_MEMBER,

    FETCH_FOOD_BOARD_LIST,
    FETCH_FOOD_BOARD,

    FETCH_BEST_FOOD_LIST,
    FETCH_FOOD_BOARD_COMMENTS_LIST,
    FETCH_MY_CART_FOOD_LIST,

    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE_BOARD,

    FETCH_REGISTER_MEMBER,
    
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
    },
    [FETCH_MY_CART_FOOD_LIST](state, myCartFoods){
        state.myCartFoods = myCartFoods
    },
    [FETCH_NOTICE_BOARD_LIST](state, noticeBoards){
        state.noticeBoards = noticeBoards
    },
    [FETCH_NOTICE_BOARD](state, noticeBoard){
        state.noticeBoard = noticeBoard
    },
    [FETCH_REGISTER_MEMBER](state, registerMembers){
        state.registerMembers = registerMembers
    },


}