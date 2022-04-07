<template>
    <div>
        <table>
            <tr>
                <td>장보기 목록 읽기</td>
                <td>
                    <input type="text" :value="jpaBoard3.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>가게이름</td>
                <td>
                    <input type="text" :value="jpaBoard3.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>장보기 목록</td>
                <td>
                    <input type="text" :value="jpaBoard3.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="jpaBoard3.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" :value="jpaBoard3.content" readonly>
                    </textarea>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardRead3',
    props: {
        jpaBoard3: {
            type: Object,
            required: true
        }
    }
}
</script>