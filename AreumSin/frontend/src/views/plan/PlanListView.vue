<template>
  <div>
    <MainCategory></MainCategory>
    <div>
      {{id}}
    </div>

    <PlanPageForm v-bind:userPlans="userPlans"></PlanPageForm>

    <PencilIcon @submit="onSubmit" :id="id"/>
  </div>
</template>

<script>
import PencilIcon from "@/components/Item/PencilIcon";
import axios from "axios";
import {mapActions, mapState} from "vuex";
import PlanPageForm from "@/components/plan/PlanPageForm";
import MainCategory from "@/components/MainCategory";

export default {
  name: "PlanListView",
  components: {MainCategory, PlanPageForm, PencilIcon},
  props: {

  },
  data() {
    return {
      id: localStorage.getItem("session") || "",
    }
  },
  methods: {
    ...mapActions(['fetchUserPlans']),
    onSubmit(payload){
      console.log(payload + this.userId)
      let id = this.id;
      const {planName, planDate, placeName} = payload;
      console.log({planName, planDate, placeName, id})
      axios.post('http://localhost:7777/plan/makePlan', {planName, planDate, placeName, id})
          .then((res) => {
            console.log(res);
          })
          .catch((res) => {
            console.log(res.response.data.message);
          })
    }
  },
  computed: {
    ...mapState(['userPlans'])
  },
  mounted() {
    this.fetchUserPlans(this.id);
  }
}
</script>

<style scoped>

</style>