<template>
    <div>
        <table2>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="questionBoard.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="questionBoard.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="questionBoard.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="questionBoard.createdDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="10" :value="questionBoard.content" style="color:white" readonly>
                    </textarea>
                </td>
            </tr>
        </table2>
    </div>
</template>

<script>

export default {
    name: 'QuestionBoardRead',
    props: {
        questionBoard: {
            type: Object,
            required: true
        }
    }
}
</script>