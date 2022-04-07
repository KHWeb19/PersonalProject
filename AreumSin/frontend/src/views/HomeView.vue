<template>
  <v-container fluid>
    <main-category></main-category>
    <CalendarComponents/>
    <BeforePencilIcon @submit="onSubmit"/>
  </v-container>
</template>

<script>

  import MainCategory from "@/components/MainCategory";
  import CalendarComponents from "@/components/CalendarComponents";
  import BeforePencilIcon from "@/components/Item/BeforePencilIcon";
  import axios from "axios";
  export default {
    name: 'HomeView',
    components: {
      BeforePencilIcon,
      CalendarComponents,
      MainCategory

    },
    methods: {
      onSubmit(payload){
        console.log(payload)
        const {planName, planDate, placeName} = payload;
        console.log({planName, planDate, placeName})
        axios.post('http://localhost:7777/plan/makePlan', {planName, planDate, placeName})
            .then((res) => {
              console.log(res);
            })
            .catch((res) => {
              console.log(res.response.data.message);
            })
      }
    }
  }
</script>

<style scoped>

</style>