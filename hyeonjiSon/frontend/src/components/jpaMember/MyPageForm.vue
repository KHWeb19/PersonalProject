<template>
    <div>
        <table>
            <tr>
                <td>회원 번호</td>
                <td>
                    <input type="text" :value="jpaBoard.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>ID</td>
                <td>
                    <input type="text" :value="jpaBoard.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>상호명</td>
                <td>
                    <input type="text" :value="jpaBoard.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="text" :value="jpaBoard.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>비밀번호 질문 답</td>
                <td>
                    <textarea cols="50" rows="20" :value="jpaBoard.content" readonly>
                    </textarea>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    
}
</script>