<template>
    <div>
        <table>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" :value="jpaBoard1.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" :value="jpaBoard1.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
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