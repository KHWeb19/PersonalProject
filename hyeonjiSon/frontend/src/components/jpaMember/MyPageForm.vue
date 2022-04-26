<template>
    <div>
        <table>
            <tr>
                <td>회원 번호</td>
                <td>
                    {{ userInfo.memberNo }}
                </td>
            </tr>
            <tr>
                <td id="left">ID</td>
                <td>
                    {{userInfo.userId }}
                </td>
            </tr>
            <tr>
                <td id="left">상호명</td>
                <td>
                    {{ userInfo.storeName }}
                </td>
            </tr>
            <tr>
                <td id="left">비밀번호</td>
                <td>
                    {{ userInfo.password }}
                </td>
            </tr>
            <tr>
                <td id="left">비밀번호 질문 답</td>
                <td>
                    {{ userInfo.passwordqanswer }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MyPageForm',
    props: {
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