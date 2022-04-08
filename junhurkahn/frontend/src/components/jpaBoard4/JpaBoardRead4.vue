<template>
    <div>
         <table border="1">
            <tr>
                <td>사이트아이디 읽기</td>
                <td>
                    <input type="text" :value="jpaBoard4.boardNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>사이트아이디</td>
                <td>
                    <input type="text" :value="jpaBoard4.title" readonly/>
                </td>
            </tr>

               <tr>
                <td>사이트이름</td>
                <td>
                    <input type="text" v-model="writer1"/>
                </td>
            </tr>


            <tr>
                <td>사이트주소</td>
                <td>
                    <input type="text" :value="jpaBoard4.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="jpaBoard4.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" :value="jpaBoard4.content" readonly>
                    </textarea>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardRead4',
    props: {
        jpaBoard4: {
            type: Object,
            required: true
        }
    }
}
</script>