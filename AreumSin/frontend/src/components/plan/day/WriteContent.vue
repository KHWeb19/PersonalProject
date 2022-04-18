<template>
  <v-container>

    <v-row style="border: black solid 1px; height: 100px">
        <input type="text" style="border: black solid 1px; width: 80%; height: 100px; font-size: 30px" v-model="content">
        <v-btn @click="sendContent" style="width: 20%; height: 100px; font-size: 30px; background-color: darkolivegreen; color: white">확인</v-btn>
    </v-row>
  </v-container>


</template>

<script>
export default {
  name: "WriteContent",
  data(){
    return{
      content: '',
      id: localStorage.getItem('session'),
      planNo: localStorage.getItem('planNo')
    }
  },
  methods:{
    sendContent(){
      const {content} = this;
      let id = this.id;
      let planNo = this.planNo;

      this.$emit('onSubmit', { id, planNo, content});
    }
  }
}
</script>

<style scoped>

</style>