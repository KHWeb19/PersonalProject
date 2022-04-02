<template>
    <div>
        <h3>회원 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">회원아이디</th>
            </tr>
            <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
                <td colspan="1">
                    현재 등록된 회원이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in members" :key="board.memberNo">
                <td align="left">
                    <router-link :to="{
                        name: 'AccountsEditPage',
                        params: {memberNo: board.memberNo.toString()}}">
                    {{ board.memberId }}
                    </router-link>
                </td>
            </tr>
        </table>

        <!-- <table border="1">
            <tr>
                <th align="center" width="100">회원아이디</th>
            </tr>
            <tr v-if="!member">
                <td colspan="1">
                    현재 등록된 회원이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in member" :key="board.memberNo">
                <td align="left">
                    <router-link :to="{
                        name: 'AccountsEditPage',
                        params: {memberNo: board.memberNo.toString()}}">
                    회원정보
                    </router-link>
                </td>
            </tr>
        </table> -->
    </div>
</template>

<script>
export default {
    name: 'MemberList',
    props: {
        members: {
            type: Array
        },
    // member: {
    //     type: String,
    //     required: true
    // }
    }
}
</script>

<style scoped>
    
</style>