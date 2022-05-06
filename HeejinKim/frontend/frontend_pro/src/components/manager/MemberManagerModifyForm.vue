<template>
 
    
      <v-row justify="center">
        <v-col cols="auto" style="padding-bottom: 90px">
           
            <v-card class="modifyCard">
              <v-card-title >
                <h3>Do you want to change Auth?</h3> 
              </v-card-title>
              <v-card-text> 
                <v-radio-group v-model="radioGroup" row>
                  <v-radio
                    color="red"
                    v-for="grades in gradesAuth"
                    :key="grades"
                    :label="`${grades}`"
                    :value="grades"
                  >
                  </v-radio>
                </v-radio-group>

              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn type="submit" @click="onSubmit" text> confirm </v-btn>

                <v-btn color="grey" text @click="goList" >Cancle</v-btn>

              </v-card-actions>
            </v-card>
            <v-overlay :value="overlay"></v-overlay>

        </v-col>
      </v-row>


</template>

<script>

export default {
  name: "MemberManagerModifyForm",
  props: {
    registerMember: {
      type: Object,
      required: true,
    },
    registerMemberAuth: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {   
       overlay: false,
      radioGroup: "",
      gradesAuth: ["Individaul", "Manager"],
      memberNo: this.registerMember.memberNo,
    };
  },
  methods: {
    onSubmit() {
      const { radioGroup } = this;
      const auth = radioGroup;
      this.$emit("submit", { auth });
    },
    goList(){
      this.$router.push({name: 'MemberManagerPage'})

    }
  },
   watch: {
      overlay (val) {
        val && setTimeout(() => {
          this.overlay = false
        }, 2000)
      },
    },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&display=swap');
.modifyCard{
  font-family: 'Poiret One', cursive;
  width:400px;
  font-weight: bold;
  margin-top:30px;
  background:rgb(248, 246, 229);
}

</style>