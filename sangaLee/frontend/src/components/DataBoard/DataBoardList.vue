<template>
    <div class="box">
        <table class="boardbox">
            <tr>
                <th width="100">NO</th>
                <th width="640">제목</th>
                <th width="150">작성자</th>
                <th width="240">등록일자</th>
            </tr>
            <tr v-if="!jpaBoards || (Array.isArray(jpaBoards) && jpaBoards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'DataBoardReadPage',
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
    name: 'DataBoardList.vue',
    props: {
      jpaBoards: {
            type: Array
        }
    }
}

</script>

<style scoped>

</style>