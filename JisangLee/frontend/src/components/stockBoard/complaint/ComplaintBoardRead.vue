<template>
    <div>
        <table2>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="complaintBoard.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="complaintBoard.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="complaintBoard.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="complaintBoard.createdDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="10" :value="complaintBoard.content" style="color:white" readonly>
                    </textarea>
                </td>
            </tr>
        </table2>
    </div>
</template>

<script>

export default {
    name: 'ComplaintBoardRead',
    props: {
        complaintBoard: {
            type: Object,
            required: true
        }
    }
}
</script>