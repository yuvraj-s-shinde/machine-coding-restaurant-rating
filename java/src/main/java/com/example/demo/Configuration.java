package com.example.demo;

import com.example.demo.commands.AddRatingCommand;
import com.example.demo.commands.AddReviewCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.DescribeRestaurantCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.GetReviewsCommand;
import com.example.demo.commands.GetReviewsFilterOrderCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListRestaurantsCommand;
import com.example.demo.commands.RegisterRestaurantCommand;
import com.example.demo.commands.RegisterUserCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.RestaurantService;
import com.example.demo.services.ReviewService;
import com.example.demo.services.UserService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IRestaurantRepository restaurantRepository = new RestaurantRepository();
            private final IUserRepository userRepository = new UserRepository();
            private final IReviewRepository reviewRepository = new ReviewRepository();

    
            // Initialize services
            private final RestaurantService restaurantService = new RestaurantService(restaurantRepository);
            private final UserService userService = new UserService(userRepository);
            private final ReviewService reviewService = new ReviewService(reviewRepository, restaurantRepository);


            // Initialize commands
            private final RegisterRestaurantCommand registerRestaurantCommand = new RegisterRestaurantCommand(restaurantService);
            private final RegisterUserCommand registerUserCommand = new  RegisterUserCommand(userService);
            private final AddRatingCommand addRatingCommand = new  AddRatingCommand(reviewService);
            private final AddReviewCommand addReviewCommand = new  AddReviewCommand(reviewService);
            private final GetReviewsCommand getReviewsCommand = new  GetReviewsCommand(reviewService);
            private final GetReviewsFilterOrderCommand getReviewsFilterOrderCommand = new  GetReviewsFilterOrderCommand(reviewService);
            private final DescribeRestaurantCommand describeRestaurantCommand = new  DescribeRestaurantCommand(restaurantService);
            private final ListRestaurantsCommand listRestaurantsCommand = new  ListRestaurantsCommand(restaurantService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.REGISTER_RESTAURANT_COMMAND.getName(),registerRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.REGISTER_USER_COMMAND.getName(),registerUserCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_RATING_COMMAND.getName(),addRatingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_REVIEW_COMMAND.getName(),addReviewCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_COMMAND.getName(),getReviewsCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_FILTER_ORDER_COMMAND.getName(),getReviewsFilterOrderCommand);
                commandRegistry.registerCommand(CommandKeyword.DESCRIBE_RESTAURANT_COMMAND.getName(),describeRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_RESTAURANT_COMMAND.getName(),listRestaurantsCommand);

            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
