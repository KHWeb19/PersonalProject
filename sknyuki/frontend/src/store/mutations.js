import {
    FETCH_BRAND_CHECK_BOARD_LIST,
    FETCH_BRAND_CHECK_BOARD,

    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,

    USER_LOGIN,
    FETCH_USER_INFO,
    FETCH_SESSION,

    FETCH_CHECK_BRAND_COMMENTS,
    FETCH_CHECK_BRAND_COMMENT,

    FETCH_QUESTION_COMMENTS,
    FETCH_QUESTION_COMMENT,

    FETCH_PRODUCT_BOARDS_LIST,
    FETCH_PRODUCT_BOARDS,

} from './mutation-types'

export default {
    [FETCH_BRAND_CHECK_BOARD_LIST] (state, brandCheckBoards) {
        state.BrandCheckBoards = brandCheckBoards
   },

    [FETCH_BRAND_CHECK_BOARD ] (state, brandCheckBoard) {
        state.BrandCheckBoard = brandCheckBoard
   },

    [FETCH_QUESTION_BOARD_LIST] (state, QuestionBoards) {
      state.QuestionBoards = QuestionBoards
   },

    [FETCH_QUESTION_BOARD ] (state, QuestionBoard) {
      state.QuestionBoard = QuestionBoard
   },


      [USER_LOGIN] (state, isLogin) {
        state.isLogin = isLogin
        console.log('isLogin: ' + isLogin)
      },
      [FETCH_USER_INFO] (state, userInfo) {
        state.userInfo = userInfo
        console.log('userInfo' + userInfo)
      },
      [FETCH_SESSION] (state, session) {
        state.session = session
      },


      [FETCH_CHECK_BRAND_COMMENTS] (state, comments) {
        state.checkbrandComments = comments
      },
      
      [FETCH_CHECK_BRAND_COMMENT] (state, comment) {
        state.checkbrandComment = comment
      },

      [FETCH_QUESTION_COMMENTS] (state, comments) {
        state.QuestionComments = comments
      },

      [FETCH_QUESTION_COMMENT] (state, comment) {
        state.QuestionComment = comment
      },


      [FETCH_PRODUCT_BOARDS_LIST] (state, ProductBoardSs) {
        state.ProductBoardSs = ProductBoardSs
   },

      [FETCH_PRODUCT_BOARDS] (state, ProductBoardS) {
         state.ProductBoardS = ProductBoardS
   },
}
