<template>
    <div style="font-size: 14px;">
        <div style="color: gray; font-weight: bold; padding-bottom: 8px">회원님을 위한 추천</div>
        <!-- <v-col style="height: 320px; text-align: center;" v-if="!members || (Array.isArray(members) && members.length === 0)">
                현재 등록된 게시물이 없습니다!
        </v-col> -->
        <div v-for="member in members" :key="member.memberNo" cols="4">
            <div v-if="member.memberNo!=loginInfo.memberNo" style="display: flex; padding: 8px 5px">
                <div>
                    <td>
                        <div style="border-radius: 70%; overflow: hidden; width: 32px ">
                            <v-img v-if="member.imageName" width="32" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                            <v-img v-else width="32" src="@/assets/profile.jpg"/>
                        </div>
                    </td>
                </div>
                <div>
                    <td align="left" width="100" style="padding-left: 12px; line-height: 16px">
                        <router-link style="text-decoration: none; color: black" :to="{
                            name: 'MyProfilePage',
                            params: {memberNo: member.memberNo.toString()}}">
                                <b>{{ member.memberId }}</b>
                        </router-link>
                        <div style="color: gray">{{ member.memberName }}</div>
                    </td>
                    
                </div>
                <div>
                    <td align="right" width= "100" style="padding-top: 5px">
                        버튼
                        <!-- <home-follow-button :memberNo="member.memberNo" :myFollows="myFollows"/> -->
                    </td>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
export default {
    name: 'RecommendList',
    props: {
        members: {
            type: Array
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },
}
</script>