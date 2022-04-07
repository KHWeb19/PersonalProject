<template>
    <div>
        <table>
            <tr>
                <td>장보기 목록 읽기</td>
                <td>
                    <input type="text" :value="jpaBoard2.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>가게이름</td>
                <td>
                    <input type="text" :value="jpaBoard2.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>장보기 목록</td>
                <td>
                    <input type="text" :value="jpaBoard2.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="jpaBoard2.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" :value="jpaBoard2.content" readonly>
                    </textarea>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardRead2',
    props: {
        jpaBoard2: {
            type: Object,
            required: true
        }
    }
}
</script>