//
//  MainViewController.h
//  TenChou
//
//  Created by Caius Chance on 12/09/10.
//  Copyright Inspiready 2010. All rights reserved.
//

#import "FlipsideViewController.h"

@interface MainViewController : UIViewController <FlipsideViewControllerDelegate> {
        UITextField    *textField;
}

@property (nonatomic, retain) IBOutlet UITextField *textField;

- (IBAction)showInfo:(id)sender;

- (IBAction)textFieldReturn:(id)sender;
- (IBAction)backgroundTouched:(id)sender;

@end
