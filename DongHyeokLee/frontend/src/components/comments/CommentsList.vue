<template>
    <div>
        <h3>댓글 목록</h3>
        <table>
            <tr v-for="comment in comments" :key="comment.commentNo">
               <td allign="center">
                    {{ comment.content}}
                </td>
            <tr>
                <td align="center">
                    {{ comment.writer }}
                </td>
            </tr>
            <tr>
                <td align="center">
                    {{ comment.regDate }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'FreeBoardList',
    props: {
      freeBoards: {
            type: Array
        }
    }
}

</script>