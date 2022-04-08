<template>
    <div>
        <h3>생일관리</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="150">이름</th>
                <th align="center" width="250">생년월일</th>
                <th align="center" width="440">메모</th>
                <th align="center" width="240">등록날짜</th>
            </tr>
            <tr v-if="!jpaBoards3 || (Array.isArray(jpaBoards3) && jpaBoards3.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards3" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'JpaBoardReadPage3',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="right">
                    {{ board.writer }}
                 </td>
                <td align="right">
                    {{ board.content }}
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
    name: 'JpaBoardList3',
    props: {
      jpaBoards3: {
            type: Array
        }
    }
}
</script>