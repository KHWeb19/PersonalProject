<template>
    <div>
        <form @submit.prevent="onSubmit">

      <br> 

            <div>
                <v-text-field label="아이디" style="width:350px" :value="userInfo.userId" disabled/>
            </div>

            <div>
                <v-text-field label="닉네임/상호명" style="width:350px" :value="userInfo.storeName"> </v-text-field>
            </div>

            <div>
                <v-text-field label="거주 시" style="width:350px" :value="userInfo.city"> </v-text-field>
            </div>

            <div>
                <v-text-field label="거주 동" style="width:350px" :value="userInfo.dong"> </v-text-field>
            </div>

            <div>
                <v-text-field label="나머지 주소" style="width:350px" :value="userInfo.address"> </v-text-field>
            </div>
        </form>

        <v-btn id="findPw" @click="modify">
          정보 수정
        </v-btn>

    </div>
</template>

<script>

export default {
    name: 'MyPageForm',
    props: {
        userInfo: {
            type: Object,
            required: true
        },
    },
    methods: {
        modify(){
            const { sn, city, dong, adress } = this
                this.$emit('submit', { sn, city, dong, adress })
        }
    },
    created(){
        this.sn = this.userInfo.sn
        this.city = this.userInfo.city
        this.dong = this.userInfo.dong
        this.address = this.userInfo.address
    }

}
</script>

<style scoped>
.v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }

</style>