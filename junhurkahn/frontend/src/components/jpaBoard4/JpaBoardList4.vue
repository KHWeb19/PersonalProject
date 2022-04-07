<template>
    <div>
        <h3>사이트아이디 관리</h3>
        <table border="1">
            <tr>
                <th align="center" width="200">번호</th>
                <th align="center" width="440">사이트 주소</th>
                <th align="center" width="150">사이트 아이디</th>
                <th align="center" width="240">등록날짜</th>
            </tr>
            <tr v-if="!jpaBoards4 || (Array.isArray(jpaBoards4) && jpaBoards4.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards4" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'JpaBoardReadPage4',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="right">
                    {{ board.writer }}
                </td>
                <td align="center">
                    {{ board.regDate }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardList4',
    props: {
      jpaBoards4: {
            type: Array
        }
    }
}
</script>