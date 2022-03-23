<template>
    <div class="d-flex flex-column">
        <div class="d-flex justify-center">
            <div><v-img src="@/assets/logo.png/" height="38" width="38"/></div>
            <div>
                <h1>아이디</h1>
                <button class="blue--text" type="button">프로필 사진 바꾸기</button>
            </div>
        </div>
        <div class="d-flex justify-center">
            <form @submit.prevent="onSubmit">
                <div class="d-flex justify-center">
                    이름
                    <div>
                    <input type="text" v-model="title"/>
                    <div>사람들이 이름, 별명 또는 비즈니스 이름 등 회원님의 알려진 이름을 사용하여 회원님의 계정을 찾을 수 있도록 도와주세요.</div>
                    </div>
                </div>
                <div>
                    소개
                    <textarea rows="5" v-model="content"></textarea>
                </div>
                <div>
                    아이디
                    <input type="text" v-model="writer"/>
                </div>
                <div>
                    비밀번호
                    <input type="text" v-model="writer"/>
                </div>
                <div class="d-flex justify-center">
                    <v-btn color="blue" class="white--text" type="submit">제출</v-btn>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: 'AccountsEditPage',
    data() {
        return {

        }
        
    },

}
</script>

<style scoped>



</style>