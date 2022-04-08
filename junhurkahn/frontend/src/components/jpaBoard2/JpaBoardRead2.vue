<template>
    <div>
        <table border="1">
            <tr>
                <td>장보기 목록 읽기</td>
                <td>
                    <input type="text" :value="jpaBoard2.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>가게이름</td>
                <td>
                    <input type="text" :value="jpaBoard2.content" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="jpaBoard2.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>물건목록</td>
                <td>
                    <textarea cols="50" rows="20" :value="jpaBoard2.title" readonly>
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