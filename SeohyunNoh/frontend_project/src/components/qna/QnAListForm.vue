<template>
    <div>
        <v-row justify="center" class="mb-3 mt-3 text-center">
            <h3><strong>Q & A</strong></h3>
        </v-row>

        <table class="table table-bordered">
            <b-thead>
                <tr align="center">
                    <th align="center" width="100">번호</th>
                    <th align="center" width="640">제목</th>
                    <th align="center" width="150">작성자</th>
                    <th align="center" width="240">등록일자</th>
                </tr>
            </b-thead>
            <b-tbody>
                <tr v-if="!qnaBoards || (Array.isArray(qnaBoards) && qnaBoards.length === 0)">
                    <td colspan="4">
                        현재 등록된 게시물이 없습니다!
                    </td>
                </tr>
                <tr v-else v-for="qnaBoard in qnaBoards" :key="qnaBoard.qnaNo">
                    <td align="center">
                        {{ qnaBoard.qnaNo }}
                    </td>
                    <td align="left">
                        <router-link :to="{ name: 'QnAReadPage',
                                            params: { qnaNo: qnaBoard.qnaNo.toString() } }">
                            {{ qnaBoard.title }}
                        </router-link>
                    </td>
                    <td align="center">
                        {{ qnaBoard.writer }}
                    </td>
                    <td align="center">
                        {{ qnaBoard.regDate.split('T')[0] }}
                        
                    </td>
                </tr>
            </b-tbody>
        </table>
    </div>
</template>

<script>

export default {
    name: 'QnAListForm',
    props: {
      qnaBoards: {
            type: Array
        }
    }
}

</script>

<style scoped>

table{
    width: 100%;
    border: 1px solid #ebecec;
}
.top-tr {
    background-color: #f6f7f7;
}
.board-box {
    margin-top: 5%;
}
h5 {
    margin-top: 0px;
    font-size: 18px;
    margin-left: 40%;
}
.member-box {
    margin-top: 2%;
}
</style>