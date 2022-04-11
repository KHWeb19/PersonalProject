<template>
    <div>
        <table>
            <tr>
                <td>회원 번호</td>
                <td>
                    {{ member.memberNo }}
                </td>
            </tr>
            <tr>
                <td id="left">ID</td>
                <td>
                    {{ member.userId }}
                </td>
            </tr>
            <tr>
                <td id="left">상호명</td>
                <td>
                    {{ member.storeName }}
                </td>
            </tr>
            <tr>
                <td id="left">비밀번호</td>
                <td>
                    {{ member.password }}
                </td>
            </tr>
            <tr>
                <td id="left">비밀번호 질문 답</td>
                <td>
                    {{ member.passwordqanswer }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MyPageForm',
    props: {
        Member: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            userInfo: JSON.parse(localStorage.getItem('userInfo'))
        }
    }
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