<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <v-container style="width: 400px; margin-top: 85px; padding-left: 0px">
        <v-flex>
            <v-card style="padding: 8px">
                <tr v-for="member in searchMembers" :key="member.memberNo">
                    <router-link style="text-decoration: none; color: black" :to="{
                            name: 'MyProfilePage',
                            params: {memberNo: member.memberNo.toString()}}">
                        <div style="display: flex; padding: 3px 0px">
                            <div>
                                <td style="padding: 10px 5px 0px 15px">
                                    <div style="border-radius: 70%; overflow: hidden; width: 44px ">
                                        <v-img v-if="member.imageName" width="44" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                                        <v-img v-else width="44" src="@/assets/profile.jpg"/>
                                    </div>
                                </td>
                            </div>
                            <div>
                                <td align="left" style="width: 400px; padding: 8px">
                                    <b>{{ member.memberId }}</b><br/>{{ member.memberName }}
                                </td>
                            </div>
                        </div>
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