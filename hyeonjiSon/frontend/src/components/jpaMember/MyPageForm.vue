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
                <td id="left">시</td>
                <td>
                    {{ userInfo.city }}
                </td>
            </tr>
            <tr>
                <td id="left">동</td>
                <td>
                    {{ userInfo.dong }}
                </td>
            </tr>
                <tr>
                    <td id="left">주소</td>
                    <td>
                        {{ userInfo.address }}
                    </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MyPageForm',
    props: {
        userInfo: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
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