<template>
    <div>
        <h3>계좌번호 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="200">번호</th>
                <th align="center" width="440">은행명</th>
                <th align="center" width="150">계좌번호</th>
                <th align="center" width="240">등록날짜</th>
            </tr>
            <tr v-if="!jpaBoards1 || (Array.isArray(jpaBoards1) && jpaBoards1.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards1" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'JpaBoardReadPage1',
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
    name: 'JpaBoardList1',
    props: {
      jpaBoards1: {
            type: Array
        }
    }
}
</script>