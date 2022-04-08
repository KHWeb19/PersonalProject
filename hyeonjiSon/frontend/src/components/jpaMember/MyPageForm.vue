<template>
    <div>
        <table>
            <tr>
                <td>회원 번호</td>
                <td>
                    <input id="right" type="text" :value="member.memberNo" readonly/>
                </td>
            </tr>
            <tr>
                <td id="left">ID</td>
                <td>
                    <input id="right" type="text" :value="member.userId" readonly/>
                </td>
            </tr>
            <tr>
                <td id="left">상호명</td>
                <td>
                    <input id="right" type="text" :value="member.storeName" readonly/>
                </td>
            </tr>
            <tr>
                <td id="left">비밀번호</td>
                <td>
                    <input id="right" type="text" :value="member.password" readonly/>
                </td>
            </tr>
            <tr>
                <td id="left">비밀번호 질문 답</td>
                <td>
                    <textarea cols="50" rows="20" :value="member.passwordqanswer" readonly>
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

<style scoped>
    #right{
        border-bottom: 2px solid;
    }
    #left{
        border-bottom: 1px solid;
    }

</style>