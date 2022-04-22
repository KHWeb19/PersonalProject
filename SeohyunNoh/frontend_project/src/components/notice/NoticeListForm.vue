<template>
    <div>

        <v-row justify="center" class="mb-3 mt-3 text-center">
            <h3><strong>NOTICE</strong></h3>
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
                <tr v-if="!noticeBoards || (Array.isArray(noticeBoards) && noticeBoards.length === 0)">
                    <td colspan="4">
                        현재 등록된 게시물이 없습니다!
                    </td>
                </tr>
                <tr v-else v-for="noticeBoard in noticeBoards" :key="noticeBoard.boardNo">
                    <td align="center">
                        {{ noticeBoard.boardNo }}
                    </td>
                    <td align="left">
                        <router-link :to="{ name: 'NoticeReadPage',
                                            params: { boardNo: noticeBoard.boardNo.toString() } }">
                            {{ noticeBoard.title }}
                        </router-link>
                    </td>
                    <td align="center">
                        {{ noticeBoard.writer }}
                    </td>
                    <td align="center">
                        {{ noticeBoard.regDate.split('T')[0] }}
                        
                    </td>
                </tr>
            </b-tbody>
        </table>
    </div>
</template>

<script>


export default {
    name: 'NoticeListForm',
    props: {
      noticeBoards: {
            type: Array
        }
    }
}

</script>