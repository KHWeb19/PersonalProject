import {
    FETCH_MEMBER,
    FETCH_MEMBER_LIST,
    FETCH_SEARCH_MEMBER_LIST,
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_BOARD_MY_LIST,
    FETCH_COMMENT,
    FETCH_COMMENT_LIST,
    FETCH_TWO_COMMENT_LIST,
    FETCH_LIKES_LIST,
    FETCH_MY_LIKES_LIST,
    FETCH_LIKE,
    FETCH_MY_FOLLOW_LIST,
    FETCH_FOLLOW_BOARD_LIST
} from './mutation-types'

export default {
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_SEARCH_MEMBER_LIST] (state, searchMembers) {
        state.searchMembers = searchMembers
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD_MY_LIST] (state, myBoards) {
        state.myBoards = myBoards
    },
    [FETCH_COMMENT] (state, comment) {
        state.comment = comment
    },
    [FETCH_COMMENT_LIST] (state, comments) {
        state.comments = comments
    },
    [FETCH_TWO_COMMENT_LIST] (state, twoComments) {
        state.twoComments = twoComments
    },
    [FETCH_LIKES_LIST] (state, likes) {
        state.likes = likes
    },
    [FETCH_MY_LIKES_LIST] (state, myLikes) {
        state.myLikes = myLikes
    },//네네 이부분 그러면 이중에서 해당게시물이면 true로 하는건데 일단 다시 해보겠습니다!!!!!!!!! 넵 
    [FETCH_LIKE] (state, like) {
        state.like = like
    },
    //네네 문제가 뭔지는 알겠는데...like를 list로 받아서 각각 출력이되어야한다. 네 잘모르겠습니다..
    //이미 걸러서 like에 저장한건데 그걸 여러번해서 문제가 생긴게 아닌가요?
    //처음부터 list로 가져와서 아제가 이전에 리스트로 가져와서 그중에 맞는걸 vue에서 찾도록 해봤는데 
    //거기서도 문제가 있었어서 다시 이방법으로 돌아온것도 있어요 ㅠㅠ 
    //네.. 이방법은 확실히 안되겠네요 
    [FETCH_MY_FOLLOW_LIST] (state, myFollows) {
        state.myFollows = myFollows
    },
    [FETCH_FOLLOW_BOARD_LIST] (state, followBoards) {
        state.followBoards = followBoards
    },
}