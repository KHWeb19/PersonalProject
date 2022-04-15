<template>
  <div>
    <menu-bar/>
    <v-container style="width: 400px; margin-top: 20px; padding-left: 0px">
        <v-flex>
            <v-card style="padding: 8px">
                <tr v-for="member in searchMembers" :key="member.memberNo">
                    <router-link style="text-decoration: none;" :to="{
                            name: 'MyProfilePage',
                            params: {memberNo: member.memberNo.toString()}}">
                        <td align="left" style="width: 400px; padding: 8px">
                            <b>{{ member.memberId }}</b><br/>{{ member.memberName }}
                        </td>
                    </router-link>
                </tr>
            </v-card>
        </v-flex>
    </v-container>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
export default {
    name: 'MemberList',
    props: {
        searchMembers: {
            type: Array
        }
    },
    components: {
        MenuBar
    }
}
</script>

<style scoped>
    
</style>