<template>
    <div>
         <table border="1">
            <tr>
                <td>계좌번호 읽기</td>
                <td>
                    <input type="text" :value="jpaBoard1.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>은행이름</td>
                <td>
                    <input type="text" :value="jpaBoard1.title" readonly/>
                </td>
            </tr>


                <tr>
                <td>소유자이름</td>
                <td>
                    <input type="text" :value="jpaBoard1.writer1" readonly/>
                </td>
            </tr>
            <tr>


            <tr>
                <td>계좌번호</td>
                <td>
                    <input type="text" :value="jpaBoard1.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="jpaBoard1.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" :value="jpaBoard1.content" readonly>
                    </textarea>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardRead1',
    props: {
        jpaBoard1: {
            type: Object,
            required: true
        }
    }
}
</script>