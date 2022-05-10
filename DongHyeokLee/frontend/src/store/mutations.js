import {
    //자유게시판
    FETCH_FREE_BOARD_LIST,
    FETCH_FREE_BOARD,
    FETCH_FREE_BOARD_COMMENTS_LIST,
    //사진게시판
    FETCH_PHOTO_BOARD_LIST,
    FETCH_PHOTO_BOARD,
    FETCH_PHOTO_BOARD_COMMENTS_LIST,
    FETCH_PHOTO_BOARD_LIKE,
    //영상게시판
    FETCH_VIDEO_BOARD_LIST,
    FETCH_VIDEO_BOARD,
    FETCH_VIDEO_BOARD_COMMENTS_LIST,
    FETCH_VIDEO_BOARD_LIKE

    
} from './mutation-types'

export default {
    //자유게시판
    [FETCH_FREE_BOARD_LIST] (state, freeBoards) {
        state.freeBoards = freeBoards
    },
    [FETCH_FREE_BOARD] (state, freeBoard) {
        state.freeBoard = freeBoard
    },
    [FETCH_FREE_BOARD_COMMENTS_LIST] (state, freeBoardComments) {
        state.freeBoardComments = freeBoardComments
    },
    //사진게시판
    [FETCH_PHOTO_BOARD_LIST] (state, photoBoards) {
        state.photoBoards = photoBoards
    },
    [FETCH_PHOTO_BOARD] (state, photoBoard) {
        state.photoBoard = photoBoard
    },
    [FETCH_PHOTO_BOARD_COMMENTS_LIST] (state, photoBoardComments) {
        state.photoBoardComments = photoBoardComments
    },
    [FETCH_PHOTO_BOARD_LIKE](state, photoBoardLike){
        state.photoBoardLike = photoBoardLike
    },
    //영상게시판
    [FETCH_VIDEO_BOARD_LIST] (state, videoBoards) {
        state.videoBoards = videoBoards
    },
    [FETCH_VIDEO_BOARD] (state, videoBoard) {
        state.videoBoard = videoBoard
    },
    [FETCH_VIDEO_BOARD_COMMENTS_LIST] (state, videoBoardComments) {
        state.videoBoardComments = videoBoardComments
    },
    [FETCH_VIDEO_BOARD_LIKE](state, videoBoardLike){
        state.videoBoardLike = videoBoardLike
    },
}