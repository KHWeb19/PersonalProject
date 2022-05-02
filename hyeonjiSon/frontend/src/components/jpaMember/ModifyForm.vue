<template>
    <div>
        <form @submit.prevent="onSubmit">

      <br> 

            <div>
                <v-text-field label="아이디" style="width:350px" :value="userInfo.userId" readonly/>
            </div>

            <div>
                <v-text-field label="닉네임/상호명" style="width:350px" :value="userInfo.storeName" readonly/>
            </div>

            <div>
                <v-text-field label="거주 시" style="width:350px" :value="userInfo.city" readonly/>
            </div>

            <div>
                <v-text-field label="거주 동" style="width:350px" :value="userInfo.dong" readonly/>
            </div>

            <div>
                <v-text-field label="나머지 주소" style="width:350px" :value="userInfo.address" readonly/>
            </div>

        </form>
    </div>
</template>

<script>
export default {
    name: 'modifyeForm',
    props: {
        userInfo: {
            type: Object,
            required: true
        },
        memberNo: {
            type: Object,
            required: true
        }

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